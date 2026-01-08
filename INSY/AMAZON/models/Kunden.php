<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Kunden".
 *
 * @property int $KundenID
 * @property string $Kundenname
 * @property string|null $Kunden_Email
 *
 * @property Bestellungen[] $bestellungens
 */
class Kunden extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Kunden';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Kunden_Email'], 'default', 'value' => null],
            [['Kundenname'], 'required'],
            [['Kundenname', 'Kunden_Email'], 'string', 'max' => 255],
            [['Kunden_Email'], 'unique'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'KundenID' => Yii::t('app', 'Kunden ID'),
            'Kundenname' => Yii::t('app', 'Kundenname'),
            'Kunden_Email' => Yii::t('app', 'Kunden Email'),
        ];
    }

    /**
     * Gets query for [[Bestellungens]].
     *
     * @return \yii\db\ActiveQuery|BestellungenQuery
     */
    public function getBestellungens()
    {
        return $this->hasMany(Bestellungen::class, ['KundenID' => 'KundenID']);
    }

    /**
     * {@inheritdoc}
     * @return KundenQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new KundenQuery(get_called_class());
    }

}
