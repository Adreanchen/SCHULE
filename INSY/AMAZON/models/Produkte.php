<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Produkte".
 *
 * @property string $ProduktID
 * @property string $Produktname
 * @property string|null $Produktkategorie
 * @property float $Stueckpreis
 * @property int $LieferantenID
 *
 * @property Bestellungen[] $bestellnummers
 * @property Bestellpositionen[] $bestellpositionens
 * @property Lieferanten $lieferanten
 */
class Produkte extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Produkte';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Produktkategorie'], 'default', 'value' => null],
            [['ProduktID', 'Produktname', 'Stueckpreis', 'LieferantenID'], 'required'],
            [['Stueckpreis'], 'number'],
            [['LieferantenID'], 'integer'],
            [['ProduktID'], 'string', 'max' => 10],
            [['Produktname'], 'string', 'max' => 100],
            [['Produktkategorie'], 'string', 'max' => 50],
            [['ProduktID'], 'unique'],
            [['LieferantenID'], 'exist', 'skipOnError' => true, 'targetClass' => Lieferanten::class, 'targetAttribute' => ['LieferantenID' => 'LieferantenID']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'ProduktID' => Yii::t('app', 'Produkt ID'),
            'Produktname' => Yii::t('app', 'Produktname'),
            'Produktkategorie' => Yii::t('app', 'Produktkategorie'),
            'Stueckpreis' => Yii::t('app', 'Stueckpreis'),
            'LieferantenID' => Yii::t('app', 'Lieferanten ID'),
        ];
    }

    /**
     * Gets query for [[Bestellnummers]].
     *
     * @return \yii\db\ActiveQuery|BestellungenQuery
     */
    public function getBestellnummers()
    {
        return $this->hasMany(Bestellungen::class, ['Bestellnummer' => 'Bestellnummer'])->viaTable('Bestellpositionen', ['ProduktID' => 'ProduktID']);
    }

    /**
     * Gets query for [[Bestellpositionens]].
     *
     * @return \yii\db\ActiveQuery|BestellpositionenQuery
     */
    public function getBestellpositionens()
    {
        return $this->hasMany(Bestellpositionen::class, ['ProduktID' => 'ProduktID']);
    }

    /**
     * Gets query for [[Lieferanten]].
     *
     * @return \yii\db\ActiveQuery|LieferantenQuery
     */
    public function getLieferanten()
    {
        return $this->hasOne(Lieferanten::class, ['LieferantenID' => 'LieferantenID']);
    }

    /**
     * {@inheritdoc}
     * @return ProdukteQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new ProdukteQuery(get_called_class());
    }

}
