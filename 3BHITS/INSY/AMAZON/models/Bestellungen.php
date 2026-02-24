<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Bestellungen".
 *
 * @property int $Bestellnummer
 * @property string $Bestelldatum
 * @property int|null $KundenID
 *
 * @property Bestellpositionen[] $bestellpositionens
 * @property Kunden $kunden
 * @property Produkte[] $produkts
 */
class Bestellungen extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Bestellungen';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['KundenID'], 'default', 'value' => null],
            [['Bestelldatum'], 'required'],
            [['Bestelldatum'], 'safe'],
            [['KundenID'], 'integer'],
            [['KundenID'], 'exist', 'skipOnError' => true, 'targetClass' => Kunden::class, 'targetAttribute' => ['KundenID' => 'KundenID']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'Bestellnummer' => Yii::t('app', 'Bestellnummer'),
            'Bestelldatum' => Yii::t('app', 'Bestelldatum'),
            'KundenID' => Yii::t('app', 'Kunden ID'),
        ];
    }

    /**
     * Gets query for [[Bestellpositionens]].
     *
     * @return \yii\db\ActiveQuery|BestellpositionenQuery
     */
    public function getBestellpositionens()
    {
        return $this->hasMany(Bestellpositionen::class, ['Bestellnummer' => 'Bestellnummer']);
    }

    /**
     * Gets query for [[Kunden]].
     *
     * @return \yii\db\ActiveQuery|KundenQuery
     */
    public function getKunden()
    {
        return $this->hasOne(Kunden::class, ['KundenID' => 'KundenID']);
    }

    /**
     * Gets query for [[Produkts]].
     *
     * @return \yii\db\ActiveQuery|ProdukteQuery
     */
    public function getProdukts()
    {
        return $this->hasMany(Produkte::class, ['ProduktID' => 'ProduktID'])->viaTable('Bestellpositionen', ['Bestellnummer' => 'Bestellnummer']);
    }

    /**
     * {@inheritdoc}
     * @return BestellungenQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new BestellungenQuery(get_called_class());
    }

}
